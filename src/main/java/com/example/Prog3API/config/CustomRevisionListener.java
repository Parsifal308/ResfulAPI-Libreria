package com.example.Prog3API.config;

import org.hibernate.envers.RevisionListener;

import com.example.Prog3API.entities.audit.Revision;

public class CustomRevisionListener implements RevisionListener{

	@Override
	public void newRevision(Object revisionEntity) {
		final Revision revision = (Revision)revisionEntity;
		
	}

}
