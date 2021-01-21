@Test public void partialWithLiteralPaths() throws IOException {
  String string="Dudes: {{> [dude]}}";
  String dude="{{name}}";
  Object hash=$("name","Jeepers","another_dude","Creepers");
  shouldCompileToWithPartials(string,hash,$("dude",dude),"Dudes: Jeepers","Partials can use literal paths");
}
