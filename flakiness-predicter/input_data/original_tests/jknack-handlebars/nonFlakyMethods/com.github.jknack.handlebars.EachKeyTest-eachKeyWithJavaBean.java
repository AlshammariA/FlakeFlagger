@Test public void eachKeyWithJavaBean() throws IOException {
  Blog blog=new Blog("Handlebars.java","...");
  String result=compile("{{#each this}}{{@key}}: {{this}} {{/each}}").apply(blog);
  String expected1="body: ... title: Handlebars.java ";
  String expected2="title: Handlebars.java body: ... ";
  assertTrue(result.equals(expected1) || result.equals(expected2));
}
