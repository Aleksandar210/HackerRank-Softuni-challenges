using System;
using Microsoft.EntityFrameworkCore.Migrations;

namespace EntityFrameworkHospitalAppCodeFirst.Migrations
{
    public partial class UpdatePasswordType : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AlterColumn<byte[]>(
                name: "Password",
                table: "Doctors",
                type: "BINARY(50)",
                maxLength: 50,
                nullable: false,
                oldClrType: typeof(string),
                oldType: "nvarchar(50)",
                oldMaxLength: 50);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AlterColumn<string>(
                name: "Password",
                table: "Doctors",
                type: "nvarchar(50)",
                maxLength: 50,
                nullable: false,
                oldClrType: typeof(byte[]),
                oldType: "BINARY(50)",
                oldMaxLength: 50);
        }
    }
}
