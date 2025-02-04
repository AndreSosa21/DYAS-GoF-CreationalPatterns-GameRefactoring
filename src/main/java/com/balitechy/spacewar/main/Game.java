package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;

import com.balitechy.interfaces.SpritesFactory;
import com.balitechy.interfaces.VectorsFactory;
import com.balitechy.interfaces.gameFactory;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 320;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int SCALE = 2;
    public final String TITLE = "Space War 2D";

    private boolean running = false;
    private Thread thread;
    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

    // Modo Sprite (true) o Vector (false)
    private boolean useSprite = false;

    private SpritesImageLoader sprites;
    
    // Componentes del juego
    private com.balitechy.interfaces.playerFactory player;
    private BulletController bullets;
    private com.balitechy.interfaces.backgroundFactory backgRenderer;
    private gameFactory factory;
    
    public Game(boolean useSpriteMode) {
        this.useSprite = useSpriteMode;
    }
    
    public void init() {
        requestFocus();

        // Si se usa el modo sprite, se carga la imagen de sprites.
        if(useSprite) {
            sprites = new SpritesImageLoader("/sprites.png");
            try {            
                sprites.loadImage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        // Agregar el listener de teclado
        addKeyListener(new InputHandler(this));
        
        // Seleccionar la fábrica según el modo elegido
        if(useSprite) {
            factory = new SpritesFactory();
            // Usar la fábrica de sprites para crear los componentes del juego
            backgRenderer = factory.crearBackgroundFactory();
            bullets = factory.crearBulletFactory(this);
            player = factory.crearPlayerFactory(this);
        } else {
            // Se asume que tienes una clase VectorFactory que implementa gameFactory.
            factory = new VectorsFactory();
            backgRenderer = factory.crearBackgroundFactory();
            bullets = factory.crearBulletFactory(this);
            player = factory.crearPlayerFactory(this);
        }
    }
    
    // Acceso a sprites, en modo sprite es necesario.
    public SpritesImageLoader getSprites() {
        return sprites;
    }
    
    public BulletController getBullets() {
        return bullets;
    }
    
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        switch(key) {
            case KeyEvent.VK_RIGHT:
                player.setVelX(5);
                break;
            case KeyEvent.VK_LEFT:
                player.setVelX(-5);
                break;
            case KeyEvent.VK_UP:
                player.setVelY(-5);
                break;
            case KeyEvent.VK_DOWN:
                player.setVelY(5);
                break;
            case KeyEvent.VK_SPACE:
                player.shoot();
                break;
        }
    }
    
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        switch(key) {
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_LEFT:
                player.setVelX(0);
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                player.setVelY(0);
                break;
        }
    }
    
    private synchronized void start() {
        if(running) return;
        
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    private synchronized void stop() {
        if(!running) return;
        
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }
    
    @Override
    public void run() {
        init();
        
        long lastTime = System.nanoTime();
        final double numOfTicks = 60.0;
        double ns = 1000000000 / numOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();
        
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if(delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(updates + " ticks, fps " + frames);
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }
    
    public void tick() {
        player.tick();
        bullets.tick();
    }
    
    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        /////////////////////////////////////////
        try {
            backgRenderer.render(g, this);
            player.render(g);
            bullets.render(g);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /////////////////////////////////////////
        g.dispose();
        bs.show();
    }
    
    public static void main(String args[]) {        
        // Por defecto, se usa sprite; si se pasa el argumento "vector", se cambia el modo.
        boolean useSpriteMode = false;
        if(args.length > 0 && args[0].equalsIgnoreCase("vector")) {
            useSpriteMode = false;
        }
        
        Game game = new Game(useSpriteMode);
        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        
        JFrame frame = new JFrame(game.TITLE);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        game.start();
	}
}