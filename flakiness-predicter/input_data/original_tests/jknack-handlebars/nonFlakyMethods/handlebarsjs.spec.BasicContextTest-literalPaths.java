@Test public void literalPaths() throws IOException {
  Object hash=$("@alan",$("expression","beautiful"));
  shouldCompileTo("Goodbye {{[@alan]/expression}} world!",hash,"Goodbye beautiful world!","Literal paths can be used");
}
