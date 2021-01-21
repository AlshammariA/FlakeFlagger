@Test public void escapeUnescape(){
  DocumentMK mk=createMK();
  String rev;
  String nodes;
  Random r=new Random(1);
  for (int i=0; i < 20; i++) {
    int len=1 + r.nextInt(5);
    StringBuilder buff=new StringBuilder();
    for (int j=0; j < len; j++) {
      buff.append((char)(32 + r.nextInt(128)));
    }
    String s=buff.toString();
    String x2=Utils.escapePropertyName(s);
    String s2=Utils.unescapePropertyName(x2);
    if (!s.equals(s2)) {
      assertEquals(s,s2);
    }
    if (s.indexOf('/') >= 0) {
      continue;
    }
    JsopBuilder jsop=new JsopBuilder();
    jsop.tag('+').key(s).object().key(s).value("x").endObject();
    rev=mk.commit("/",jsop.toString(),null,null);
    nodes=mk.getNodes("/" + s,rev,0,0,100,null);
    jsop=new JsopBuilder();
    jsop.object().key(s).value("x").key(":childNodeCount").value(0).endObject();
    String n=jsop.toString();
    assertEquals(n,nodes);
    nodes=mk.getNodes("/",rev,0,0,100,null);
    jsop=new JsopBuilder();
    jsop.object().key(s).object().endObject().key(":childNodeCount").value(1).endObject();
    n=jsop.toString();
    assertEquals(n,nodes);
    jsop=new JsopBuilder();
    jsop.tag('-').value(s);
    rev=mk.commit("/",jsop.toString(),rev,null);
  }
}
