@Test public void singleNodeTypeMiss(){
  NodeState node=createNodeOfType(NT_BASE);
  TypePredicate p=new TypePredicate(node,new String[]{NT_FILE});
  assertFalse(p.apply(node));
}
