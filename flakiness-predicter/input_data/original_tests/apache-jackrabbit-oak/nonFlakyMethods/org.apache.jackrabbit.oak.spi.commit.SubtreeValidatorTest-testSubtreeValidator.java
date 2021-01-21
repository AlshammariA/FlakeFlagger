@Test public void testSubtreeValidator() throws CommitFailedException {
  Validator delegate=new FailingValidator();
  Validator validator=new SubtreeValidator(delegate,"one","two");
  assertNull(validator.childNodeAdded("zero",EMPTY_NODE));
  assertNull(validator.childNodeChanged("two",EMPTY_NODE,EMPTY_NODE));
  assertNull(validator.childNodeDeleted("foo",EMPTY_NODE));
  assertNotNull(validator.childNodeAdded("one",EMPTY_NODE));
  assertNotNull(validator.childNodeChanged("one",EMPTY_NODE,EMPTY_NODE));
  assertNotNull(validator.childNodeDeleted("one",EMPTY_NODE));
  validator=validator.childNodeChanged("one",EMPTY_NODE,EMPTY_NODE);
  assertNull(validator.childNodeAdded("zero",EMPTY_NODE));
  assertNull(validator.childNodeChanged("one",EMPTY_NODE,EMPTY_NODE));
  assertNull(validator.childNodeDeleted("foo",EMPTY_NODE));
  assertEquals(delegate,validator.childNodeAdded("two",EMPTY_NODE));
  assertEquals(delegate,validator.childNodeChanged("two",EMPTY_NODE,EMPTY_NODE));
  assertEquals(delegate,validator.childNodeDeleted("two",EMPTY_NODE));
}
