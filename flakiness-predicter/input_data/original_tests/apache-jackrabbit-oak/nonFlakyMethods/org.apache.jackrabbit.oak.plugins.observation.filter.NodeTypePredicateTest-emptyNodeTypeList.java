@Test public void emptyNodeTypeList(){
  NodeState node=createNodeOfType(NT_BASE);
  TypePredicate p=new TypePredicate(node,new String[]{});
  assertFalse(p.apply(node));
}
