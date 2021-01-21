@Test(expected=RuntimeException.class) public void testProdThrowsError() throws Exception {
  PropertiesConfiguration defaultConfiguration=new PropertiesConfiguration();
  Configuration compositeConfiguration=new PropertiesConfiguration();
  String uuid=UUID.randomUUID().toString();
  String baseDirWithoutTrailingSlash="/tmp/ninja-test-" + uuid;
  boolean isProd=true;
  NinjaPropertiesImplTool.checkThatApplicationSecretIsSet(isProd,baseDirWithoutTrailingSlash,defaultConfiguration,compositeConfiguration);
  FileUtils.deleteDirectory(new File(baseDirWithoutTrailingSlash));
}
