---------------------------------------------------------
 jlGui : JAVA music player for Java platform.

 Project Homepage :
   http://www.javazoom.net/jlgui/jlgui.html

 MP3 & JAVA Forums :
   http://www.javazoom.net/services/forums/index.jsp

 JNLP (JavaWebStart) configurator :
   http://www.javazoom.net/jlgui/jnlp_configurator.jsp
   
 Contact :
   jlgui@javazoom.net
---------------------------------------------------------

INSTALLATION :
------------
To launch jlGui just double click under jlgui3.0.jar. If nothing appears try 
"java -jar jlgui3.0.jar" command. If it still fail then edit jlgui.bat 
(or jlgui.sh) script and setup JAVA_HOME variable before launching the script.

- To play local file or playlist : Left click on "Eject" button.
- To play remote file/stream     : Right click on "Eject" Button.
- To load a new skin  file       : Left click on "Eject" button 
                                   or right click in top pop-up menu.                                  
- To fill in playlist : Use the playlist front-end or open your 
                        own M3U (or PLS) file.

You might notice that some features (buttons, pop-up) are not working. It's 
because it has not been implemented yet (see TODO section at the bottom of 
this file).

Have fun, 
 JavaZOOM Team.


CHANGES :
-------

 11/14/2006 : jlGui 3.0
 ----------------------
 - Spectrum/Time analyzer added through KJ 1.1.
 - FLAC audio format support added through JFlac 1.2.
 - Monkey's Audio format support added through JMac 1.74.
 - Search in playlist feature added.
 - UI code refactored :
    + Switch from AWT to SWING.
    + Skin class added.
 - Preferences panel improved :
    + JavaSound device panel added.
    + Visual panel added.
    + Skin browser panel added.
    + System properties panel added.
 - Pop-up menu improved :
    + Play File/Location added.
    + Playlist Editor switch added.
    + Equalizer switch added.
    + Jump to file added.
 - Skin support improved :
    + RollOver on playlist pop-up menus.
    + Spline added to equalizer.
    + Drag&Drop support added to playlist.
    + Keyboard shortcuts added.
 - jSpeex 0.9.7 included.
 - VorbisSPI 1.0.2 included.
 - MP3SPI 1.9.4 included.
 - J2SE 1.6RC support added.


 07/09/2005 : jlGui 2.3.2
 ------------------------
 - Volume value property added in jlgui.ini.
 - JLayer 1.0 included.
 - MP3SPI 1.9.2 included.
 - VorbisSPI 1.0.1 included.


 04/27/2004 : jlGui 2.3
 ----------------------
 - Equalizer feature added (for MP3 only) :
    + WinAmp skins 2.0 front-end compliant.
    + Presets
 - Seek feature now available for both WAV and MP3.
 - File Info feature improved :
    + Shoutcast ICY meta data support added.
    + ID3v1 & v2 tags loaded by MP3SPI. 
 - Design improved :
    + BasicPlayer redesigned (Threaded events, Audio properties).
    + Classes refactored.
    + Commons-logging added to manage traces.
    + jid3.jar dropped.
    + Pluggable TagInfo implementation.
      (taginfo_mpeg_impl, taginfo_oggvorbis_impl properties)      
 - Bug fixes :
    + Last song endless loop bug for playlist fixed.
    + Black pop-up menu (under Un*x) bug fixed.
    + 8 bits WAV file support fixed.
 - Skin support improvements :
    + Invisible components added.   
    + Progress Bar, Volume and Balance display problems fixed.
    + Title marquee added.
    + "Loading" and "Buffering" messages added for stream loading.
    + screen_limit parameter added to display (or not) the player in screen.
 - PLS support added for playlist.
 - Save playlist on exit added.
 - SPEEX audio format support added (jSpeex 0.9.3 included).
 - VorbisSPI 1.0 included.
 - MP3SPI 1.9.1 included.
 - J2SE 1.5.0 beta support added.


 07/01/2003 : jlGui 2.2
 ----------------------
 - OGG comments and ID3 tags viewer added.
 - PlaylistUI up&down buttons added.
 - Playlist interface improved.
    + setModified/isModified methods added.
    + setCursor method added.
 - Shuffle implemented.
 - VorbisSPI 0.7 included.
 - JOrbis 0.0.12 included.
 - MpegSPI 1.6 included.
   (It fixes WAV file non-playing bug under JDK 1.4).
 - Bug fix in "Add dir" feature under Linux.
 - Bug fix in AudioInputStream closing.
 

 04/01/2002 : jlGui 2.1.1
 ------------------------
 - Drag and Drop support added.
 - WinAmp Skins 2.0 support improved.
    + Minimize button added.
    + Double-click to play song from playlist added.
    + Add files to playlist from directory added.
    + Popup menu on title bar added.
 - MPEG 2.5 support added through JavaLayer 0.2.0.
 - JavaWebStart support added.
    + Default skin included in JAR file.
    + jlgui.jnlp sample included.
 - Configuration setup improved.
    + Load custom jlgui.ini from file or URL added.
    + Load skin from URL added.
    + Load playlist from URL added.
    + Optionally run the playlist on startup added.
 - API improved and online samples added to help developers.
 - jlGui.sh script bug fixed.
 - M3U support bug fixed to be 100% compliant with WinAmp M3U.
 
 
 03/04/2002 : jlGui 2.1
 ----------------------
 - Playlist UI added.
    + Main window, Scrollbar, Add File/Url, Inv/Crop/Remove Selection.
 - WinAmp Skins 2.0 support improved.
    + Audio files filter added.
    + Dynamic skin and playlist loading added.
    + Playlist, Shuffle, Repeat, Equalizer buttons.
 - Configuration file "jlgui.ini" added.
 - Ogg Vorbis streaming support improved (VorbisSPI 0.6 + JOrbis0.0.11).
 - MpegAudioSPI improved :
    + SYNC offset support added => ID3 tags skipped.
    + BitRate + total length in seconds info returned.
 - License moved from GPL to LGPL.
 
 
 10/01/2001 : jlGui 2.0
 ----------------------
 - MP3 streaming support for Shoutcast/Icecast added.
 - Ogg Vorbis support added.
 - Playlist implementation and M3U support added.
 - JavaLayer 0.1.1 included to improve MP3 support.
 - WinAmp Skins 2.0 support improved.
 - Seek bar added (for WAV files only).
 
 
 05/14/2000 : jlGui 1.0
 ----------------------
 - jlGui is now open source (GPL).
 - JavaLayer 0.0.8 included.
 - MpegAudioSPI (from tritonus.org) included.
 - 70% WinAmp skins compatible.


 TODO :
 ----
  + Playlist :
   - Improve "Add Dir" feature :
     You have to select a file in a directory to select the parent directory.
   - Make playlist resizable.
     bottom-right drag is not implemented.
   - Tiny play/pause/stop controls in playlist are not implemented.
   - PLS (Load/Save) buttons in playlist are not implemented.
   - MSC buttons in playlist are not implemented.
   - Add title bar to move/close it.
  + Improve equalizer :
   - Equalizer works only for MP3. 
   - Equalizer graph function is not implemented.
   - Auto button not implemented.
   - Add title bar to move/close it.
   - Left slider not implemented.
  + Improve seek feature :
   - Seek support works only for MP3 and WAV.
     It means implement skip(bytes) in underlying SPI.
  + Improve pop-up menus :
   - "Preferences" and "skins" items in title bar pop-up are not implemented.
   - popupmenu.show() blocks player thread (in progress(...) method).
  + Player
   - Add visualization.
   - The middle button (in between iconify and close) not implemented.
   - Make all windows (equalizer, player, playlist) move independantly.
   - Upper far left button not implemented.
   

 KNOWN PROBLEMS :
 --------------
 - MP3 : 99% of MP3 plays well with JavaLayer but some (1%) return an 
         ArrayIndexOutOfBoundsException while playing. 
         It's a bug (hard to fix) in the underlying JavaLayer decoder.
 - Ogg Vorbis :
   + Low sampling rates such as 14Khz are not supported.
   + AudioInputStream is closed at the end of song for some 
     (only a few) icecast streams.
 - Player :
   + It takes much more CPU under MacOSX (~70%) than under 
     Windows, Linux, Solaris (~10%).
   + Pop-up menu blocks the playback thread (temporary).
   + Pop-up right click doesn't work under Linux  
     => Use Right click + Left click to select an item.
 