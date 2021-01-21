@Test public void testInsert(){
  Mutator<String> m=createMutator(keyspace,se);
  MutationResult mr=m.insert("k","Standard1",createColumn("name","value",se,se));
  assertTrue("Execution time on single insert should be > 0",mr.getExecutionTimeMicro() > 0);
  assertTrue("Should have operated on a host",mr.getHostUsed() != null);
  assertColumnExists("Keyspace1","Standard1","k","name");
}
