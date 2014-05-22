import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.File;
import java.io.PrintStream;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;

public class MusicPlayer implements BasicPlayerListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PrintStream out = null;
	static BasicPlayer player;
	static boolean isPaused = false;

	/**
	 * Entry point.
	 * 
	 * @param args
	 *            filename to play.
	 */
	public static void main(String[] args) {
		MusicPlayer test = new MusicPlayer();
		player = new BasicPlayer();
		test.initializeGui();
		test.play(test.FileChooser());
	}

	/**
	 * Contructor.
	 */
	public MusicPlayer() {
		out = System.out;
	}

	public BasicPlayer getPlayer() {
		return player;
	}

	public BasicController getControl() {
		return (BasicController) getPlayer();
	}

	public void initializeGui() {
		final JFrame frame = new JFrame("MUSIC PLAYER");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout());
		JButton button1 = new JButton("EXIT");
		JButton button2 = new JButton("PAUSE");
		JButton button3 = new JButton("STOP");
		JButton button4 = new JButton("PLAY");
		final Scrollbar bar = new Scrollbar(Scrollbar.HORIZONTAL, 85, 1, 0, 100);
		bar.setBlockIncrement(10);

		ActionListener ExitButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				System.exit(0);
			}
		};

		ActionListener PauseButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					isPaused = true;
					getControl().pause();
				} catch (BasicPlayerException e1) {
					e1.printStackTrace();
				}
			}
		};

		ActionListener StopButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					getControl().stop();
					play(FileChooser());
				} catch (BasicPlayerException e1) {
					e1.printStackTrace();
				}
			}
		};

		ActionListener PlayButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (isPaused) {
						getControl().resume();
						isPaused = true;
					} else
						getControl().play();
				} catch (BasicPlayerException e1) {
					e1.printStackTrace();
				}
			}
		};
		AdjustmentListener batListener = new AdjustmentListener() {

			public void adjustmentValueChanged(AdjustmentEvent e) {
				try {
					getControl().setGain(bar.getValue() / 100.0);
				} catch (BasicPlayerException e1) {
					e1.printStackTrace();
				}
			}

		};

		button1.addActionListener(ExitButtonListener);
		button2.addActionListener(PauseButtonListener);
		button3.addActionListener(StopButtonListener);
		button4.addActionListener(PlayButtonListener);
		bar.addAdjustmentListener(batListener);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);

		panel.add(bar);
		frame.add(panel);
		frame.setSize(800, 90);
		frame.setResizable(false);
		frame.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2,
				(dim.height / 2 - frame.getSize().height / 2) - 250);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public String FileChooser() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"MP3 File", "mp3");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(chooser);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile().getAbsolutePath().toString();
		}
		return null;

	}

	public void play(String filename) {
		// Instantiate BasicPlayer.

		// BasicPlayer is a BasicController.
		BasicController control = this.getControl();
		// Register BasicPlayerTest to BasicPlayerListener events.
		// It means that this object will be notified on BasicPlayer
		// events such as : opened(...), progress(...), stateUpdated(...)
		getPlayer().addBasicPlayerListener(this);

		try {
			// Open file, or URL or Stream (shoutcast, icecast) to play.
			control.open(new File(filename));

			// control.open(new URL("http://yourshoutcastserver.com:8000"));

			// Start playback in a thread.
			control.play();

			// If you want to pause/resume/pause the played file then
			// write a Swing player and just call control.pause(),
			// control.resume() or control.stop().
			// Use control.seek(bytesToSkip) to seek file
			// (i.e. fast forward and rewind). seek feature will
			// work only if underlying JavaSound SPI implements
			// skip(...). True for MP3SPI and SUN SPI's
			// (WAVE, AU, AIFF).

			// Set Volume (0 to 1.0).
			control.setGain(0.85);
			// Set Pan (-1.0 to 1.0).
			control.setPan(0.0);
		} catch (BasicPlayerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open callback, stream is ready to play.
	 * 
	 * properties map includes audio format dependant features such as bitrate,
	 * duration, frequency, channels, number of frames, vbr flag, ...
	 * 
	 * @param stream
	 *            could be File, URL or InputStream
	 * @param properties
	 *            audio stream properties.
	 */
	public void opened(Object stream, Map properties) {
		// Pay attention to properties. It's useful to get duration,
		// bitrate, channels, even tag such as ID3v2.
		display("opened : " + properties.toString());
	}

	/**
	 * Progress callback while playing.
	 * 
	 * This method is called severals time per seconds while playing. properties
	 * map includes audio format features such as instant bitrate, microseconds
	 * position, current frame number, ...
	 * 
	 * @param bytesread
	 *            from encoded stream.
	 * @param microseconds
	 *            elapsed (<b>reseted after a seek !</b>).
	 * @param pcmdata
	 *            PCM samples.
	 * @param properties
	 *            audio stream parameters.
	 */
	public void progress(int bytesread, long microseconds, byte[] pcmdata,
			Map properties) {
		// Pay attention to properties. It depends on underlying JavaSound SPI
		// MP3SPI provides mp3.equalizer.
		display("progress : " + properties.toString());
	}

	/**
	 * Notification callback for basicplayer events such as opened, eom ...
	 * 
	 * @param event
	 */
	public void stateUpdated(BasicPlayerEvent event) {
		// Notification of BasicPlayer states (opened, playing, end of media,
		// ...)
		display("stateUpdated : " + event.toString());
	}

	/**
	 * A handle to the BasicPlayer, plugins may control the player through the
	 * controller (play, stop, ...)
	 * 
	 * @param controller
	 *            : a handle to the player
	 */
	public void setController(BasicController controller) {
		display("setController : " + controller);
	}

	public void display(String msg) {
		if (out != null)
			out.println(msg);
	}
}