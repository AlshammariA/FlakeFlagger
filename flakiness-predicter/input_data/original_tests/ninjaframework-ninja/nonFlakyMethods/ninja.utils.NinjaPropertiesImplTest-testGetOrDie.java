@Test(expected=RuntimeException.class) public void testGetOrDie(){
  NinjaPropertiesImpl ninjaPropertiesImpl=new NinjaPropertiesImpl(NinjaMode.dev);
  assertEquals("dev_testproperty",ninjaPropertiesImpl.getOrDie("testproperty"));
  ninjaPropertiesImpl.getOrDie("a_propert_that_is_not_in_the_file");
}
