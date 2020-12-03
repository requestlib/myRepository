import selenium
from selenium import webdriver
from time import sleep

from selenium.webdriver.common.keys import Keys

invalid=[1,6,12,23]

def main():
    global study, play, gon
    # 播放第一个视频
    for i in range(4, 25):
        if i not in invalid:
            chrome_options = webdriver.ChromeOptions()
            chrome_driver = r"chromedriver.exe"  # 指定driver
            driver = webdriver.Chrome(chrome_driver, options=chrome_options)
            # driver.get(url="https://study.enaea.edu.cn/login.do")
            driver.get('https://study.enaea.edu.cn/circleIndexRedirect.do?action=toNewMyClass&type=course&circleId=73938&syllabusId=422887&isRequired=true&studentProgress=0')
            mobileCode=driver.find_element_by_xpath('//*[@id="pc-form"]/div[2]/div[1]/div[1]/input')
            if mobileCode is not None:
                mobileCode.click()
                mobileCode.clear()
                mobileCode.send_keys("15729622862")

            password = driver.find_element_by_xpath('//*[@id="pc-form"]/div[2]/div[1]/div[2]/input')
            if password is not None:
                password.click()
                password.clear()
                password.send_keys("199211ljz.")
            login=driver.find_element_by_xpath('//*[@id="pc-form"]/div[2]/div[1]/div[4]/button')
            if login is not None:
                login.click()
            totaltime=0
            while(1):
                try:
                    firstLength=[]
                    while (len(firstLength) <= 0):
                        firstLength = driver.find_elements_by_xpath('//*[@id="J_myOptionRecords"]/tbody/tr['+str(i)+']/td[2]/span')
                    print(firstLength[0].text)
                    t=firstLength[0].text.split(':')
                    totaltime=int(t[0])*3600+int(t[1])*60+int(t[0])+30
                    study=driver.find_element_by_xpath('//*[@id="J_myOptionRecords"]/tbody/tr['+str(i)+']/td[6]/a') #进入学习

                except selenium.common.exceptions.NoSuchElementException:
                    continue
                else:
                    break
            # webdriver.ActionChains(driver).move_to_element(study).click(study).perform()
            # driver.execute_script("arguments[0].click();", study)
            study.send_keys(Keys.ENTER)
            # # sleep(3)
            # while (1):
            #     try:
            #         play=driver.find_element_by_xpath('//*[@id="replaybtn"]')
            #
            #     except selenium.common.exceptions.NoSuchElementException:
            #         continue
            #     else:
            #         break

            # driver.execute_script("arguments[0].click();", play)
            # play.send_keys(Keys.ENTER)
            # study.click()
            # driver.execute_script("$(arguments[0]).click()", button)
            # 计算继续学习次数
            # driver.execute_script("$(arguments[0]).click()", study)
            while(totaltime>0):
                if totaltime>1205:
                    sleep(1205) #等待20分钟点继续学习
                    while (1):
                        try:
                            gon = driver.find_element_by_xpath(
                                '//*[@id="rest_tip"]/table/tbody/tr[2]/td[2]/div[3]/button')

                        except selenium.common.exceptions.NoSuchElementException:
                            continue
                        else:
                            break
                    gon.click()
                    totaltime -= 1205
                else:
                    sleep(totaltime)
                    break

            # sleep(totaltime)

            driver.quit()


# 1 6 12 23
main()