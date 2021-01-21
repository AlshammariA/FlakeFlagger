@Test public void stringDecimalFormat() throws IOException {
  Handlebars hbs=createMock(Handlebars.class);
  Context ctx=createMock(Context.class);
  Template fn=createMock(Template.class);
  Options options=new Options.Builder(hbs,ctx,fn).setParams(new Object[]{10.0 / 3.0}).build();
  assertEquals("stringFormat",stringFormat.name());
  assertEquals("10 / 3 = 3.33",stringFormat.apply("10 / 3 = %.2f",options));
}
