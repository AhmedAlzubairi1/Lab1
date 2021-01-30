import requests, json, pyowm
from datetime import date
import board
import neopixel
import time
#We wait to allow time for the pi to connect to internet
time.sleep(30)
pixel_pin = board.D21

# The number of NeoPixels
num_pixels = 8
 
# The order of the pixel colors - RGB or GRB. Some NeoPixels have red and green reversed!
# For RGBW NeoPixels, simply change the ORDER to RGBW or GRBW.
ORDER = neopixel.RGB
 
pixels = neopixel.NeoPixel(
    pixel_pin, num_pixels, brightness=0.2, auto_write=False, pixel_order=ORDER
)
def blink():
    global pixels
    # Here I blink blue and purple to represent rain is coming
    #GRB
    pixels.fill((0,0,255))
    pixels.show()
    time.sleep(0.1)
    
    pixels.fill((0,128,128))
    pixels.show()
    time.sleep(0.1)
    print('rainbow')

    

def normal():
    global pixels
    # I make a solid green color to represent the no rain indication
    pixels.fill((255,0,0))
    pixels.show()
    time.sleep(1)
    
    print('normal')
def will_rain():
    # base URL
    BASE_URL = "https://api.openweathermap.org/data/2.5/weather?"
    CITY = "New York"
    API_KEY = "1af163a7e26daeeb2a085b21b7909998"
    # upadting the URL
    URL = BASE_URL + "q=" + CITY + "&appid=" + API_KEY
    owm=pyowm.OWM(API_KEY)
    mgr = owm.weather_manager()
    # Above code is standard setup for the api. We then make a call to the lat and lon coordinates of NYC
    one_call = mgr.one_call(lat=40.7128, lon=74.0060)
    # Next three lines is string manipulation to get the current day
    current_day_weather=str(one_call.forecast_hourly[0].reference_time)
    today_date=current_day_weather[current_day_weather.find('reference_time='):]
    today_date=today_date[today_date.find('='):][9:11]
    # I set isRain default to false unless the next hour already tells me it is going to rain
    isRain=False or 'rain' in one_call.forecast_hourly[0].status.lower()
    for hour in one_call.forecast_hourly:
        if isRain:
            # If any hour indicates rain, I know it will rain today, so i exit
            break
        # Now i do string manipulation again to get the day of the hour. This is because forecast_hourly gives me the next 48 hours and i only want to check for today's results
        this_date_weather=str(hour.reference_time)
        this_date=this_date_weather[this_date_weather.find('reference_time='):]
        this_date=this_date[this_date.find('='):][9:11]
        if this_date != today_date:
            # If we are in tomorrow's day, we exit
            break
        if 'rain' in hour.status.lower():
            isRain=True
            break
    return   isRain
#I want to avoid calling will_rain everytime, thus I would only call it only if a new day has occured. This means i need to keep track of a global current day variable
global_day=str(date.today().day)
#I only do the will_rain method if I am in a new day
in_diff_day=True
rain=False
#while true should be here
while True:

    if in_diff_day:
        if will_rain():
            rain=True
        else:
            rain=False
    if rain:
        blink()
    else:
        normal()
    if str(date.today().day) != global_day:
        in_diff_day=True
    else:
        in_diff_day=False
    # If we are im a different day, we should update our current day to reprsent this
    if in_diff_day:
        global_day=str(date.today().day)
