@Test public void testGetRealClassNameLowerCamelCase(){
  MySuperTestObject mySuperTestObject=new MySuperTestObject();
  assertEquals("mySuperTestObject",SwissKnife.getRealClassNameLowerCamelCase(mySuperTestObject));
}
