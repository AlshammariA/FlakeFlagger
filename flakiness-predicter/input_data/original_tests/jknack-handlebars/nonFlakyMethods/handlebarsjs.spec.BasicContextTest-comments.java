@Test public void comments() throws IOException {
  shouldCompileTo("{{! Goodbye}}Goodbye\n{{cruel}}\n{{world}}!","{cruel: cruel, world: world}","Goodbye\ncruel\nworld!","comments are ignored");
}
