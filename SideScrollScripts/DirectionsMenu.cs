using UnityEngine;
using System.Collections;

public class DirectionsMenu : MonoBehaviour
{
    public void PlayGame()
    {
        Application.LoadLevel(1);
    }

    public void HowToPlay()
    {
        Application.LoadLevel(2);
    }

    public void MainMenu()
    {
        Application.LoadLevel(0);
    }

    public void ExitGame()
    {
        Application.Quit();
    }
}