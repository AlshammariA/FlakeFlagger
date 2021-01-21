@Test public void shouldHaveNoErrorWhenNoOptions() throws Exception {
  cssLint.setOptions("");
  final URL url=getClass().getResource("sample/content.css");
  cssLint.validate(IOUtils.toString(new FileInputStream(url.getFile())));
}
