package test.rpc.grpc

import java.io.{FileInputStream, FileOutputStream}
import test.rpc.protobuff.AddressBookProtos.{AddressBook, Person}
import scala.collection.JavaConverters._


/**
  * Created by acp on 09-01-2017.
  */
object ProtoBufferTest {

  def main(args: Array[String]) {
    println("Hello, GRPC!")
    val ADDRESS_FILE = "/tmp/adressbook"
    //Building a person
    val person = Person.newBuilder()
    person.setName("Alex")
    person.setId(123)
    person.setEmail("test@test")
    val person_bl = person.build()
    //Add person to address book
    val addressBook = AddressBook.newBuilder()
    addressBook.addPerson(person)
    val output = new FileOutputStream(ADDRESS_FILE)
    addressBook.build().writeTo(output)
    output.close()
    println("Wrote to file in Protocol buffer format")
    // Now read from Address
    println("Going to read from adress book")
    val addressBookRead =
      AddressBook.parseFrom(new FileInputStream(ADDRESS_FILE))
    for (person: Person <- addressBookRead.getPersonList.asScala) {
      println(person.getId())
      println(person.getName)
    }
    println("Program Over")

  }


}
