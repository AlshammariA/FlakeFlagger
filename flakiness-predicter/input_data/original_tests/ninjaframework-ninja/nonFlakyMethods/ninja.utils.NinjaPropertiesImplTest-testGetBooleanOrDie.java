@Test(expected=RuntimeException.class) public void testGetBooleanOrDie(){
  NinjaPropertiesImpl ninjaPropertiesImpl=new NinjaPropertiesImpl(NinjaMode.dev);
  assertEquals(true,ninjaPropertiesImpl.getBooleanOrDie("booleanTestTrue"));
  ninjaPropertiesImpl.getBooleanOrDie("booleanNotValid");
}
