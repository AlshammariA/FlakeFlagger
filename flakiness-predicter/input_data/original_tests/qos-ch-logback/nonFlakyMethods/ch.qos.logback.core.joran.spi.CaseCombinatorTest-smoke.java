@Test public void smoke(){
  CaseCombinator p=new CaseCombinator();
  List<String> result=p.combinations("a-B=");
  List<String> witness=new ArrayList<String>();
  witness.add("a-b=");
  witness.add("A-b=");
  witness.add("a-B=");
  witness.add("A-B=");
  assertEquals(witness,result);
}
