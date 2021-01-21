@Test public void includes(){
  Revision lower=new Revision(0xff,0,1);
  Revision low=new Revision(0x100,0,1);
  Revision high=new Revision(0x300,0,1);
  Revision higher=new Revision(0x301,0,1);
  Revision r=new Revision(0x200,0,1);
  Revision other=new Revision(0x200,0,2);
  Range range=new Range(high,low,0);
  assertTrue(range.includes(low));
  assertTrue(range.includes(high));
  assertTrue(range.includes(r));
  assertFalse(range.includes(lower));
  assertFalse(range.includes(higher));
  assertFalse(range.includes(other));
}
