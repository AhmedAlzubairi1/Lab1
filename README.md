# Lab1- Rain Warning System
Lab 1 for creative embedded systems
## Sources:
https://www.youtube.com/watch?v=KkyIDI6rQJI&list=PLtCjdO3LPoYmmKm_PnB4iODCfneR2liOR&index=1&t=198s&ab_channel=TheCodingTrain

## What is it?

This is an early warning system to tell you and the public of incoming rain.
Connect your pi to a monitor and put the monitor w/ LED lights outside your window so that the public can know when to expect rain in a fun creative way. 
The LED would flash purple and blue whenever rain is expected to come that day, but be a solid green when it doesn't expect any rain.

## Installation 
Install Processing by running:
```
curl https://processing.org/download/install-arm.sh | sudo sh
```

Install the libraries needed for the neopixel by running:
```
sudo pip3 install rpi_ws281x adafruit-circuitpython-neopixel
sudo python3 -m pip install --force-reinstall adafruit-blinka
```

The python modules should be preinstalled already with python3. This is the only other module you need to manually install. Run:

```
pip3 install pyowm
```

## Setting up Wiring
Follow the bottom link for the wiring. I used GPIO pin 21. You need to use the same.
https://learn.adafruit.com/neopixels-on-raspberry-pi/raspberry-pi-wiring

## Running the Program
You need to just modify the rc.local and the autostart file. My file directories maybe different from yours, so change the text accordingly. 
 - Inside your rc.local, all you need to do is just cd into the Lab1 directory and then run:
  ```
  sudo python3 code.py
  ```
  See the rc.local file for an example.
  - Inside the autostart file, run:
    ```
    processing-java --sketch=X --run
    ```
    In this case, X should be the folder path to the LabOneProcessing folder. See my autostart example. 

## More Documentation

The code has been very well documented through comments. See for more info. 
## Bugs:

If you git in a situation where git isn't allowing you to push some of the files because they are too big, run the following:
```
git config --global http.version HTTP/1.1
git config --global http.postBuffer 524288000
```

If you can't find the autostart file, check this directory:
 /etc/xdg/lxsession/LXDE-pi

