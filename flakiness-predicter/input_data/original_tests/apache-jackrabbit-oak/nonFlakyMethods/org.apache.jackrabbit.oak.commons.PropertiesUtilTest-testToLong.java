@SuppressWarnings("UnnecessaryBoxing") @Test public void testToLong(){
  assertEquals(2,PropertiesUtil.toLong(null,2));
  assertEquals(2,PropertiesUtil.toLong(1.0,2));
  assertEquals(2,PropertiesUtil.toLong(new Double(1.0),2));
  assertEquals(5,PropertiesUtil.toLong(new Long(5),2));
  assertEquals(5,PropertiesUtil.toLong(new Integer(5),2));
  assertEquals(2,PropertiesUtil.toLong("abc",2));
}
