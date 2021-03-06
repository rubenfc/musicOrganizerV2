import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }
    
    /**
     * realiza una impresion del listado de las canciones guardadas
     */
    public void listAllFiles()
    {
        int count = 1;
        for(String fileName : files)
        {
            System.out.println(count + ".-" +fileName);
            count++;
        }
    }
    
    public void listMaching (String searchString)
    {
        boolean existeUnaCancion = false;
        for (String filename : files)
        {
            if (filename.contains(searchString))
            {
                System.out.println(filename);
                existeUnaCancion = true;
            } 
        }
        
        
        if (existeUnaCancion == false)
        {
            System.out.println ("error no se encuentra ningun archivo con ese nombre");
        }
    }
    
      public void playMusic(String artista)
    {
        for (String filename : files)
        {
            boolean existeArtista = false;
            if(filename.contains(artista))
            {
                player.playSample(filename);
                existeArtista = true;
            }
            
            if(existeArtista = false)
            {
                System.out.println ("eror, no hay almacenada ninguna cancion de ese artista");
            }
        }
    }
    
    public int findFirst(String searchString)
    {
        int index = 0;
        boolean found = false;
        int sizeFind = files.size();
        
        while(!found && index < sizeFind)
        {
            String fileName = files.get(index);
            if(fileName.contains(searchString))
            {
                found = true;
            }
            else
            {
               index= index + 1;
            }
        }
        if(!found)
        {
             index = -1;
        }
        return index;
    }
  
}
