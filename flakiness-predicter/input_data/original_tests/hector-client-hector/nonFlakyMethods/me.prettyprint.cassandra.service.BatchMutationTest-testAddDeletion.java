@Test public void testAddDeletion(){
  Deletion deletion=new Deletion(System.currentTimeMillis());
  SlicePredicate slicePredicate=new SlicePredicate();
  slicePredicate.addToColumn_names(StringSerializer.get().toByteBuffer("c_name"));
  deletion.setPredicate(slicePredicate);
  batchMutate.addDeletion("key1",columnFamilies,deletion);
  assertEquals(1,batchMutate.getMutationMap().get(StringSerializer.get().toByteBuffer("key1")).size());
  deletion=new Deletion(System.currentTimeMillis());
  slicePredicate=new SlicePredicate();
  slicePredicate.addToColumn_names(StringSerializer.get().toByteBuffer("c_name2"));
  deletion.setPredicate(slicePredicate);
  batchMutate.addDeletion("key1",columnFamilies,deletion);
  assertEquals(2,batchMutate.getMutationMap().get(StringSerializer.get().toByteBuffer("key1")).get("Standard1").size());
}
