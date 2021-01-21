@Test public void testNinjaModeHelperWorksWithProdSet(){
  System.setProperty(NinjaConstant.MODE_KEY_NAME,NinjaConstant.MODE_PROD);
  assertEquals(NinjaMode.prod,NinjaModeHelper.determineModeFromSystemProperties().get());
  assertEquals(NinjaMode.prod,NinjaModeHelper.determineModeFromSystemPropertiesOrDevIfNotSet());
  System.clearProperty(NinjaConstant.MODE_KEY_NAME);
}
