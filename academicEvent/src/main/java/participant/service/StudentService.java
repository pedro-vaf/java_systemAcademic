package participant.service;

import participant.BaseParticipant;
import participant.ParticipantRegistration;
import participant.Student;

import java.text.ParseException;
import java.util.Scanner;

public class StudentService extends ParticipantRegistration {

    @Override
    protected BaseParticipant createParticipant(String name, int age, String email, int id) {
        return new Student(name, age, email, id);
    }

    public void registerStudent(Scanner sc) throws ParseException {
        registerParticipant(sc, 1);
    }
}