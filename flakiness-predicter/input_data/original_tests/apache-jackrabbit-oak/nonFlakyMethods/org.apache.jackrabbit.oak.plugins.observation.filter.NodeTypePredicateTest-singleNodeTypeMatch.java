@Test public void singleNodeTypeMatch(){
  NodeState node=createNodeOfType(NT_BASE);
  TypePredicate p=new TypePredicate(node,new String[]{NT_BASE});
  assertTrue(p.apply(node));
}
