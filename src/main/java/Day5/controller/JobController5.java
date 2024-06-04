package Day5.controller;

import Day5.dao.JobDAO5;
import jakarta.ws.rs.*;
import Day5.models.Jobs5;


import java.util.ArrayList;

@Path("jobs")
public class JobController5 {


   JobDAO5 dao = new JobDAO5();



    @GET
    public ArrayList<Jobs5> getAllJobs() {

        try {
            return dao.selectAllJobs();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GET
    @Path("{JobId}")
    public Jobs5 getDepartment(@PathParam("JobId") int JobId) {

        try {
            return dao.selectJob(JobId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DELETE
    @Path("{JobId}")
    public void deleteJob(@PathParam("JobId") int JobId) {

        try {
            dao.deleteJob(JobId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @POST
    public void insertJob(Jobs5 jobs) {

        try {
            dao.insertJob(jobs);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("{JobId}")
    public void updateJob(@PathParam("JobId") int JobId, Jobs5 jobs) {

        try {
            jobs.setJob_id(JobId);
            dao.updateJob(jobs);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
