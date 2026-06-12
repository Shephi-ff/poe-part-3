/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3;

/**
 *
 * @author Delicia
 */
import java.util.*;
import java.io.*;

public class MessageSystem {

static Scanner input=new Scanner(System.in);

static ArrayList<String> sent=new ArrayList<>();
static ArrayList<String> stored=new ArrayList<>();
static ArrayList<String> ignored=new ArrayList<>();
static ArrayList<String> ids=new ArrayList<>();
static ArrayList<String> hashes=new ArrayList<>();
static ArrayList<String> recipients=new ArrayList<>();

static int total=0;

public static void sendMessages(){

System.out.print("How many messages? ");
int num=input.nextInt();
input.nextLine();

for(int i=1;i<=num;i++){

System.out.print("Recipient (+27): ");
String r=input.nextLine();

System.out.print("Message: ");
String m=input.nextLine();

String id=createID();
String hash=i+":"+m.split(" ")[0].toUpperCase();

System.out.println("1 Send");
System.out.println("2 Disregard");
System.out.println("3 Store");

int op=input.nextInt();
input.nextLine();

switch(op){

case 1:
sent.add(m);
break;

case 2:
ignored.add(m);
break;

case 3:
stored.add(m);
store(id,hash,r,m);
break;

}

ids.add(id);
hashes.add(hash);
recipients.add(r);

total++;
}

System.out.println("Total Sent: "+total);
}

public static String createID(){

return String.valueOf(
100000000+
new Random().nextInt(900000000));

}

public static void store(
String id,
String hash,
String r,
String m){

try{

FileWriter f=
new FileWriter(
"storedMessages.json",
true);

f.write(id+" "
+hash+" "
+r+" "
+m+"\n");

f.close();

}catch(Exception e){}
}

public static void displaySentMessages(){

for(String x:sent)

System.out.println(x);

}

public static void storedMessagesMenu(){

System.out.println(
"1 Display");

System.out.println(
"2 Longest");

System.out.println(
"3 Search ID");

System.out.println(
"4 Search Recipient");

System.out.println(
"5 Delete");

System.out.println(
"6 Report");

int c=input.nextInt();

input.nextLine();

switch(c){

case 1:

for(int i=0;i<stored.size();i++){

System.out.println(
recipients.get(i));

}

break;

case 2:

String longMsg="";

for(String s:stored)

if(s.length()>longMsg.length())

longMsg=s;

System.out.println(longMsg);

break;

case 3:

System.out.print("ID: ");

String id=input.nextLine();

int x=ids.indexOf(id);

if(x!=-1)

System.out.println(
stored.get(x));

break;

case 4:

System.out.print(
"Recipient: ");

String r=input.nextLine();

for(int i=0;i<recipients.size();i++)

if(recipients.get(i)
.equals(r))

System.out.println(
stored.get(i));

break;

case 5:

System.out.print(
"Hash: ");

String h=input.nextLine();

int y=
hashes.indexOf(h);

if(y!=-1){

stored.remove(y);

hashes.remove(y);

}

break;

case 6:

for(int i=0;i<stored.size();i++){

System.out.println(
ids.get(i));

System.out.println(
hashes.get(i));

System.out.println(
recipients.get(i));

System.out.println(
stored.get(i));

}

}

}
}

