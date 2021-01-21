@Test public void testGetBooleanParsing(){
  NinjaPropertiesImpl ninjaPropertiesImpl=new NinjaPropertiesImpl(NinjaMode.dev);
  assertEquals(true,ninjaPropertiesImpl.getBoolean("booleanTestTrue"));
  assertEquals(false,ninjaPropertiesImpl.getBoolean("booleanTestFalse"));
  assertEquals(null,ninjaPropertiesImpl.getBoolean("booleanNotValid"));
}
