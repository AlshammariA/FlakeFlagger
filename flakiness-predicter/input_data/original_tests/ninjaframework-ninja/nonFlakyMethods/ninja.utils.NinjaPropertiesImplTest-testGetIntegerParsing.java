@Test public void testGetIntegerParsing(){
  NinjaPropertiesImpl ninjaPropertiesImpl=new NinjaPropertiesImpl(NinjaMode.dev);
  assertEquals(new Integer(123456789),ninjaPropertiesImpl.getInteger("integerTest"));
  assertEquals(null,ninjaPropertiesImpl.getInteger("integerNotValid"));
}
