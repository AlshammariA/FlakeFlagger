@SuppressWarnings("UnnecessaryBoxing") @Test public void testToInteger(){
  assertEquals(2,PropertiesUtil.toInteger(null,2));
  assertEquals(2,PropertiesUtil.toInteger(1.0,2));
  assertEquals(2,PropertiesUtil.toInteger(new Double(1.0),2));
  assertEquals(5,PropertiesUtil.toInteger(new Long(5),2));
  assertEquals(5,PropertiesUtil.toInteger(new Integer(5),2));
  assertEquals(2,PropertiesUtil.toInteger("abc",2));
}
