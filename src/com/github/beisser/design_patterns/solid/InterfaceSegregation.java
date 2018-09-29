package com.github.beisser.design_patterns.solid;

/**
 * Interface Segregation
 *
 * recommendation on how to split interfaces into smaller interfaces / logical units
 *
 * interfaces should only define the absolute minimum
 * there should not be the case that a client must implement a method which it does not
 * need at all
 */

class Document
{
}

// bad interface if only a machine for printing is needed
// in this case this machine would also need to implement the other two methods
interface Machine
{
    void print(Document d);
    void fax(Document d);
    void scan(Document d);
}

// better
// splitting up the interfaces in logical units
interface Printer
{
    void print(Document d);
}

interface Scanner
{
    void scan(Document d);
}

interface MultiFunction extends Printer,Scanner {
    void copy(Document d);
}

