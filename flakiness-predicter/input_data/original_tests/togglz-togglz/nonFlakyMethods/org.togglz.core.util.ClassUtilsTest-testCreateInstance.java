@Test public void testCreateInstance(){
  CharSequence string=ClassUtils.createInstance("java.lang.String",CharSequence.class);
  assertNotNull(string);
  assertTrue(string instanceof String);
  assertEquals("",string);
}
