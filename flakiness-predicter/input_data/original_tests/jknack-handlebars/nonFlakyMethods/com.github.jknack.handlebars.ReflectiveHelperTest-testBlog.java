@Test public void testBlog() throws IOException {
  shouldCompileTo("{{blog this}}",new Blog("title","body"),"blog:title");
}
