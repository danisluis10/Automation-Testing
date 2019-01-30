# Automation-Testing
Automation Testing

## Handler many cases if you see step procedure:
> - Assert.assertTrue(boolean b, String s);
For example: b => true (expect true) and s is string to show message if we got error "Don't run this case."

> - Assert.assertTrue(Utils.checkElementExist(element)); 
For example: We handle visible element or not.

> - waitForVisibilityOf to handle element is visible.

> - Tab event
```
      Point point = element.getLocation();

        int x = point.x + (int)(0.2 * element.getSize().width;
        int y = point.y + element.getSize().height/2;
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.tap(PointOption.point(x, y)).perform();
```

> - 
