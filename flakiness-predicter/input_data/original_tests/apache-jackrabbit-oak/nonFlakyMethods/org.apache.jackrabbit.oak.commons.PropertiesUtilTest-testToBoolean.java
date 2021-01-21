@Test public void testToBoolean(){
  assertEquals(true,PropertiesUtil.toBoolean(null,true));
  assertEquals(false,PropertiesUtil.toBoolean(1.0,true));
  assertEquals(false,PropertiesUtil.toBoolean(false,true));
  assertEquals(false,PropertiesUtil.toBoolean("false",true));
  assertEquals(false,PropertiesUtil.toBoolean("abc",true));
}
