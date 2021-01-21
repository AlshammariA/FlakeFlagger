@Test public void stringFormat() throws IOException {
  Handlebars hbs=createMock(Handlebars.class);
  Context ctx=createMock(Context.class);
  Template fn=createMock(Template.class);
  Options options=new Options.Builder(hbs,ctx,fn).setParams(new Object[]{"handlebars.java"}).build();
  assertEquals("stringFormat",stringFormat.name());
  assertEquals("Hello handlebars.java!",stringFormat.apply("Hello %s!",options));
}
