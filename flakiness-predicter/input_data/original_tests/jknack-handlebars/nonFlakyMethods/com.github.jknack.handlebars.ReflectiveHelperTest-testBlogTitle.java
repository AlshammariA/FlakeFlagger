@Test public void testBlogTitle() throws IOException {
  shouldCompileTo("{{blogTitle this title}}",new Blog("awesome!","body"),"blog:awesome!");
}
