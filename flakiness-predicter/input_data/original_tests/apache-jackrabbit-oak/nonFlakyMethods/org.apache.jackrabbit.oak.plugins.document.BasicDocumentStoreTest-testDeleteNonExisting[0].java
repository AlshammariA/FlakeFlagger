@Test public void testDeleteNonExisting(){
  String id=this.getClass().getName() + ".testDeleteNonExisting-" + UUID.randomUUID();
  ds.remove(Collection.NODES,id);
}
