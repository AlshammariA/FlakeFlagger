@Test public void compilingWithBasicContext() throws IOException {
  shouldCompileTo("Goodbye\n{{cruel}}\n{{world}}!","{cruel: cruel, world: world}","Goodbye\ncruel\nworld!","It works if all the required keys are provided");
}
