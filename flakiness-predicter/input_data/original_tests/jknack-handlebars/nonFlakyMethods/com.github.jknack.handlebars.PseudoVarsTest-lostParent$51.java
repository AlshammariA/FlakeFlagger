@Test public void lostParent$51() throws IOException {
  String input="{{#parent}}{{#list}}{{@index}}. {{name}} {{/list}}{{/parent}}";
  Handlebars handlebars=new Handlebars();
  Map<String,Object> parent=new HashMap<String,Object>();
  parent.put("name","px");
  parent.put("list",Arrays.asList("a","b"));
  Map<String,Object> context=new HashMap<String,Object>();
  context.put("parent",parent);
  assertEquals("0. px 1. px ",handlebars.compile(input).apply(context));
}
