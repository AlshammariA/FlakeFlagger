@SuppressWarnings({"deprecation","UnnecessaryBoxing"}) @Test public void testToDouble(){
  assertEquals(2.0,PropertiesUtil.toDouble(null,2.0),0);
  assertEquals(1.0,PropertiesUtil.toDouble(1.0,2.0),0);
  assertEquals(1.0,PropertiesUtil.toDouble(new Double(1.0),2.0),0);
  assertEquals(5.0,PropertiesUtil.toDouble(new Long(5),2.0),0);
  assertEquals(2.0,PropertiesUtil.toDouble("abc",2.0),0);
}
