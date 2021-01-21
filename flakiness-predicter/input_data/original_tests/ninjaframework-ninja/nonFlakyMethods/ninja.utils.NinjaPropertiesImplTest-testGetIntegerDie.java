@Test(expected=RuntimeException.class) public void testGetIntegerDie(){
  NinjaPropertiesImpl ninjaPropertiesImpl=new NinjaPropertiesImpl(NinjaMode.dev);
  assertEquals(new Integer(123456789),ninjaPropertiesImpl.getIntegerOrDie("integerTest"));
  ninjaPropertiesImpl.getIntegerOrDie("integerNotValid");
}
