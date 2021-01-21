@Test public void testSetProperty(){
{
    House house=new House();
    PropertySetter setter=new PropertySetter(house);
    setter.setProperty("count","10");
    setter.setProperty("temperature","33.1");
    setter.setProperty("name","jack");
    setter.setProperty("open","true");
    assertEquals(10,house.getCount());
    assertEquals(33.1d,(double)house.getTemperature(),0.01);
    assertEquals("jack",house.getName());
    assertTrue(house.isOpen());
  }
{
    House house=new House();
    PropertySetter setter=new PropertySetter(house);
    setter.setProperty("Count","10");
    setter.setProperty("Name","jack");
    setter.setProperty("Open","true");
    assertEquals(10,house.getCount());
    assertEquals("jack",house.getName());
    assertTrue(house.isOpen());
  }
}
