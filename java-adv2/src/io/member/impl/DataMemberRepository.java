package io.member.impl;

import io.member.Member;
import io.member.MemberRepository;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataMemberRepository implements MemberRepository {

	private static final String FILE_PATH = "java-adv2/temp/members-txt.dat";

	@Override
	public void add(Member member) {
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_PATH, true))) {
			dos.writeUTF(member.getId());
			dos.writeUTF(member.getName());
			dos.writeInt(member.getAge());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Member> findAll() {
		List<Member> members = new ArrayList<>();
		try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_PATH))) {
			while (dis.available() > 0) {
				Member member = new Member(dis.readUTF(), dis.readUTF(), dis.readInt());
				members.add(member);
			}
			return members;
		} catch (FileNotFoundException e) {
			return new ArrayList<>();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
