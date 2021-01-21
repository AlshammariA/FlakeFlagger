@Test public void multipleNodeTypesMatch(){
  NodeState node=createNodeOfType(NT_FILE);
  TypePredicate p=new TypePredicate(node,new String[]{NT_FOLDER,NT_RESOURCE,NT_FILE});
  assertTrue(p.apply(node));
}
